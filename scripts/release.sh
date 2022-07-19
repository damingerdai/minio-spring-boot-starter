

#!/usr/bin/env bash

set -Eeuo pipefail

version=$1

if test -z "$version"
then
    exit;
fi

echo "release new version: "$version

echo "{\n\t\"name\": \"minio-spring-boot-starter\",\n\t\"version\":\"${version}\"\n}" > package.json

npx conventional-changelog -p angular -i CHANGELOG.md -s

./gradlew setVersion -PnewVersion='${version}'

rm -r -f package.json

git add CHANGELOG.md

git commit -m "chore(release): v${version}"
# git tag v${version}