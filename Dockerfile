# ステージ1: Node.jsを使用してTailwindCSSをビルド
FROM node:23-slim AS build-tailwind
WORKDIR /app
COPY package.json package-lock.json ./
COPY tailwind.config.js ./
COPY src ./src
# COPY src/main/resources/static/input.css ./src/main/resources/static/
RUN npm install
RUN npx tailwindcss -i ./src/main/resources/static/input.css -o ./src/main/resources/static/output.css

# ステージ2: Mavenを使用してSpring Bootアプリケーションをビルド
FROM maven:3.9.9-amazoncorretto-21 AS build-app
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY --from=build-tailwind /app/src/main/resources/static/output.css ./src/main/resources/static/
RUN mvn clean package -DskipTests

# ステージ3: 実行用の最小イメージ
FROM amazoncorretto:21
WORKDIR /app
COPY --from=build-app /app/target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]