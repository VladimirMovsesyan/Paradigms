#!/bin/bash
java \
    -encoding utf-8 \
    --class-path "$(dirname "0")/lib/*" \
    clojure.main "$@"
