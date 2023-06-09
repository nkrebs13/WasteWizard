# Waste Wizard

This app uses best principles in modern Android development to show a list of drivers and their
routes in an Android application. All data is purely fictional and comes
from https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/data.

### Business Requirements for routes

- If the driver id is the same as the route id then display the route
- If the driver id is divisible by 2 then show the first R type route
- If the driver id is divisible by 5 then display the C type route
- If the driver id doesn't meet any of the above requirements, then show the I type route

### Instructions for building application

- Android Studio or Android Build Tools

### Tech Stack

- MVVM for app architecture
- [Room](https://developer.android.com/training/data-storage/room) for on-device local storage
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for UI
- [Koin](https://insert-koin.io/) for dependency injection
- [Coroutines + Flow](https://kotlinlang.org/docs/coroutines-overview.html) for asynchronous
  operations
- [Ktor](https://ktor.io/) for networking
- [Android Navigation](https://developer.android.com/jetpack/androidx/releases/navigation) For
  navigation within the app

### Other Features

- Light and dark mode
- Error + retry on networking
- Local storage into database for offline use

---

|                   Driver List                   |             Route List for Driver              | 
|:-----------------------------------------------:|:----------------------------------------------:|
| ![driver list](https://i.imgur.com/wuuZ71C.png) | ![route_list](https://i.imgur.com/ohi8JnM.png) |
| ![driver list](https://i.imgur.com/Rw1Hpq2.png) | ![route_list](https://i.imgur.com/A9cU6q6.png) |
