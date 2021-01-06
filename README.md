# spring-data-elasticsearch

### Requirements
* JDK 1.8
* Elasticsearch
* Docker

### Getting started

#### Step 1: Start a single node cluster with Docker
`docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.1`
