ubs-supermarket-checkout

This application has 3 modules

ubs-supermarket-core has all entities, repositories, and SLO implementations
  --entities are hidden as package private. Clients must use iface module to interact with core module

ubs-supermarket-iface has DTO's used by clients and external interface definitions meant to be used by clients

ubs-supermarket-web is an example of a client for SuperMarketScanner interface


To build the application execute 'mvn clean install' in the root directory

To run the example web application execute 'mvn spring-boot:run' in the root of ubs-supermarket-web module
  --Test data will be automatically generated on startup
  --Database is wiped out after stopping the server
  --index page should be at localhost:8080/index
  --to add additional test data navigate to localhost:8080/addItems
  --to test out the SupermarketScanner navigate to localhost:8080/checkout