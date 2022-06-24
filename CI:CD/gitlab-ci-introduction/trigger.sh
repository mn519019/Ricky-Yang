#!/bin/bash

echo "This will trigger the pipeline for rick-test"
curl -X POST \
     --fail \
     -F token=258e9d3034a18871fa1a6166008a41 \
     -F ref=main \
     https://git.cs.dal.ca/api/v4/projects/51808/trigger/pipeline
