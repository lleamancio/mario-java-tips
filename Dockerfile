# ── Build stage ──────────────────────────────────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-21-jammy AS builder

WORKDIR /app

# Copy POM first so dependency layer is cached separately
COPY pom.xml .
RUN mvn dependency:resolve -q --no-transfer-progress

COPY src ./src
COPY frontend ./frontend

# Production build: bundles frontend assets into the JAR
RUN mvn clean package -Pproduction -DskipTests --no-transfer-progress -q

# ── Runtime stage ─────────────────────────────────────────────────────────────
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Non-root user for security
RUN addgroup --system --gid 1001 appgroup && \
    adduser  --system --uid 1001 --ingroup appgroup appuser

COPY --from=builder /app/target/*.jar app.jar

RUN chown appuser:appgroup app.jar

USER appuser

# PORT is injected by Railway / Render at runtime; defaults to 8080
ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", \
  "-XX:+UseContainerSupport", \
  "-XX:MaxRAMPercentage=75.0", \
  "-jar", "app.jar"]
