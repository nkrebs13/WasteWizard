# Waste Wizard

This app uses best principles in modern Android development to show a list of drivers and their
routes in an Android application. All data is purely fictional and comes
from https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/data.

### Business Requirements for routes

- If the driver id is the same as the route id then display the route
- If the driver id is divisible by 2 then show the first R type route
- If the driver id is divisible by 5 then display the C type route
- If the driver id doesn't meet any of the above requirements, then show the I type route

###  Instructions for building application

- Android Studio or Android Build Tools

### Tech Stack
- Jetpack Compose for UI
- Koin for dependency injection
- Ktor for networking
- Room for database cache
- Coroutines for asynchronous operations

### Other Features
- Light and dark mode
- Error + retry on networking
- Local storage into database for offline use

---

|                   Driver List                   |             Route List for Driver              | 
|:-----------------------------------------------:|:----------------------------------------------:|
| ![driver list](https://i.imgur.com/wuuZ71C.png) | ![route_list](https://i.imgur.com/ohi8JnM.png) |
| ![driver list](https://i.imgur.com/Rw1Hpq2.png) | ![route_list](https://i.imgur.com/A9cU6q6.png) |
