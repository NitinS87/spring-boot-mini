# spring-boot-mini

Nitin Sharma - 20csu074
Kartik Shukla - 20csu048
Anshul Dogra - 20csu019
Manan Sethi - 20csu059

User Id 
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/b4da30fe-bcab-4bc1-89a2-7a95c7807086)



Checkpoint 6.2
TODO 6.2
• Inside this controllers package, create a class named AdminController which will serve as the
controller class.
• Mark this class as Controller class using @RestController annotation.
• Map the class AdminController with URI as ‘/hirewheels/v1’ using @RequestMapping.
• Inside this class, define a method AddVehicle(), which adds a new vehicle to the database.
• Map this method AddVehicle with @PostMapping annotation and URI as ‘/vehicles’.
• Specify the consumes and produces attributes of @PostMapping as
MediaType.APPLICATION_JSON_VALUE.
• Return the ResponseEntity, which returns the detail of vehicle successfully added along with the
status code as HttpStatus.CREATED.
TEST CHECKPOINT:
Pass the following POST request with the following RequestBody
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/fd050235-2b9b-43f2-bea5-0049e2d586ff)
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/bb9d7f86-276b-4eb5-a5a8-6ba78c696e42)

 

Checkpoint 6.3
TODO 6.3
• Inside the AdminController class, define a method UpdateVehicle(), which updates the
availability status of the specified vehicle with the id passed in the request URL.
• Map this method Update with PutMapping and URI as ‘/vehicles/{id}’, where id is a variable that
needs to be captured using @PathVariable annotation.
• Specify the consumes and produces attributes of @PutMapping as
MediaType.APPLICATION_JSON_VALUE.
• Use the {id} and call the method changeAvailability declared inside the AdminService to change
the availability of the passed vehicle in the URI.
• Return the ResponseEntity, which returns the updated vehicle along with the status code as
HttpStatus.ACCEPTED.
TEST CHECKPOINT:
Pass the following PUT request with the following RequestBody.
Request: localhost:8081/hirewheels/v1/vehicles/3
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/ce56ce72-b92a-4007-8cb7-3e1329495253)
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/249342d9-e223-49af-b64d-770bf2b969d8)

 
 

Checkpoint 6.4
TODO 6.4
• Inside this controllers package, create a class named BookingController which will serve as the
controller class.
• Mark the BookingController class as Controller class using @RestController annotation.
• Map the class BookingController with URI as ‘/hirewheels/v1’ using @RequestMapping.
• Inside this class, define a method AddBooking(), which adds a new booking in the database.
• Map this method AddBooking with PostMapping and URI as ‘/bookings'.
• Specify the consumes and produces attributes of @PostMapping as
MediaType.APPLICATION_JSON_VALUE.
TEST CHECKPOINT:
Pass the following POST request with the following RequestBody.
Request: localhost:8081/hirewheels/v1/bookings
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/7fc33d7a-3404-4748-908d-0f6177b9a147)
![image](https://github.com/NitinS87/spring-boot-mini/assets/80587065/3f8e9526-7df8-4ed5-afe9-0c8683525d27)


 
 

