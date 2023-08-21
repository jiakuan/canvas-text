#!/usr/bin/env bash
set -eu

SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo "Script path: ${SCRIPT_PATH}"

compile_scss() {
  OUT_DIR=${SCRIPT_PATH}/src/main/webapp
  sass --no-source-map --style=compressed ${SCRIPT_PATH}/src/main/scss/$1.scss ${OUT_DIR}/$1.min.css
  echo "Generated and minified: $1.min.css"
}

compile_scss "demo"
