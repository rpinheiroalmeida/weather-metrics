# weather-metrics
API service which will retrieve the average forecast weather metrics of a specific city.

- Prerequisite

It's necessary install maven in your machine. To more informations about see: https://maven.apache.org/install.html
To run the application you need execute this command:

- How to run

mvn exec:java -Dexec.mainClass="Main"  -Dexec.args="api.key"

For example:
mvn exec:java -Dexec.mainClass="Main"  -Dexec.args="b79bfe9da8b121e51883b30b37fa7460"

The serve will run in address:

http://localhost:4567

- Important decisions:

--> I keep the code simplest as possible, and this guide me to take 
some decisions as:
 - Use spark as framework for REST
 - Use Gson as Serializer and Deserializer Json
 - The cache I used a data structered LikedHashMap, without needs any
 framework or database
 - Another important decision was separate the domain objects from the
 presentation and data send by OpenWeatherMap. With this, my business
 logic is indenpendent of any changes in the Json send by OpenWeatherMap 
 and future changes required by Json that I send as response.
