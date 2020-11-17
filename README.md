## About
MyRetail is a RESTFUL service that retrieves product and price details by ID as well as updating the product and price details in the database.

## Getting Started

### Development Environment
*  Version Control - Git
*  Dependency Management - Maven 3.8.1
*  Database - MongoDb
*  RESTful Application framework - Spring Boot
*  Programming language - Java 11
*  Unit Testing library - Mockito
*  API Integration Testing - PostMan

### Commands

Clone the repository
```
$ git clone https://github.com/aaronwang23/MyRetail.git
```

### Running Repository
1. Open the project in your preferred relevant IDE of choice and run MyRetailApplication.
2. Start your local MongoDB server, I'm using MongoDB Compass Community
3. On the MongoDB server connect to port 27017 and create a new Database called "ProductStore" and the collection name "Product"
4. Run the project in the IDE 

You can now navigate to http://localhost:8080/products/ and append an id. If the id exists in the Target Redsky API then making a GET call will return you details of the product id including the id, title, and pricing details. You can update the pricing details by making a PUT call and in the body, the changes of the pricing detail as seen below. 
```
{
"id": "544561192",
"title": "Peanut Butter",
"price": {"currentPrice":"$4","currencyCode":"USD"}
}
```

##  Gallery
