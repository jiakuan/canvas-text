LATEST_TAG?=`git tag|sort -t. -k 1,1n -k 2,2n -k 3,3n -k 4,4n | tail -1`
PROJECT_DIR := $(shell dirname $(realpath $(lastword $(MAKEFILE_LIST))))

help:
	cat Makefile.txt

clean:
	./gradlew clean

scss:
	chmod +x ${PROJECT_DIR}/demo/scss.sh && ${PROJECT_DIR}/demo/scss.sh

.PHONY: build
build:
	./gradlew build && \
	cd ${PROJECT_DIR}/canvas-text && mvn j2cl:build

run: build
	chmod +x ${PROJECT_DIR}/demo/start_server.sh && ${PROJECT_DIR}/demo/start_server.sh

release:
	./gradlew release -Prelease.useAutomaticVersion=true

publish:
	rm -rf $$HOME/.m2/repository/org/docstr/canvas-text
	./gradlew build publishMavenJavaPublicationToMavenLocal publishMavenJavaPublicationToMavenRepository
