FROM container-registry.oracle.com/graalvm/native-image:latest AS graalvm

RUN microdnf -y install wget unzip zip findutils tar

COPY . /app
WORKDIR /app

RUN \
    curl -s "https://get.sdkman.io" | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    sdk install maven; \
    mvn package -Pnative native:compile -DskipTests

FROM container-registry.oracle.com/os/oraclelinux:9-slim

EXPOSE 8005
COPY --from=graalvm app/target/worthreadingservice /app

ENTRYPOINT ["/app"]
