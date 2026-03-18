#!/bin/sh
exec "$GRADLE_HOME/bin/gradle" "$@" 2>/dev/null || \
  curl -s "https://services.gradle.org/distributions/gradle-8.2-bin.zip" -o /tmp/gradle.zip && \
  unzip -q /tmp/gradle.zip -d /tmp/gradle-dist && \
  /tmp/gradle-dist/gradle-8.2/bin/gradle "$@"
