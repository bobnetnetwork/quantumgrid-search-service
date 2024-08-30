# Search Service

The **Search Service** provides full-text search capabilities across content in the QuantumGrid platform.

## Features

- Full-text search across posts, pages, and comments
- Indexing of content for efficient search
- Faceted search and filtering
- Auto-suggestion and auto-complete

## Technology Stack

- **Java**: Programming language
- **Spring Boot**: Microservice framework
- **Elasticsearch**: Search engine for indexing and searching content
- **MongoDB**: Used for additional metadata storage

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** for build automation
- **Elasticsearch** installed and running
- **MongoDB** installed and running

### Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/bobnetnetwork/quantumgrid-search-service.git
    cd quantumgrid-search-service
    ```

2. Configure the Elasticsearch and MongoDB connections in `src/main/resources/application.properties`:
    ```
    spring.data.mongodb.uri=mongodb://localhost:27017/quantumgrid
    spring.elasticsearch.rest.uris=http://localhost:9200
    ```

3. Build the application:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### API Endpoints

- `GET /api/search` - Perform a search query
- `POST /api/index` - Index new content

## Contributing

Please read the [CONTRIBUTING.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the GPL-3.0 license - see the [LICENSE.md](https://github.com/bobnetnetwork/quantumgrid/blob/main/LICENSE.md) file for details.
