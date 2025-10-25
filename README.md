# Virtual Pet Game 🐾

A Java-based virtual pet simulation game where players care for their digital companion by managing vital statistics, building relationships, and keeping their pet happy and healthy.

Video Demo link --> https://youtu.be/fElcKRz3YZI

## 🎮 About

This project was developed as part of CS2212 (Software Engineering) at Western University. It demonstrates object-oriented design principles, state management patterns, and modern software engineering practices in game development.

## ✨ Features

### Core Gameplay
- 🐕 **Three Unique Pet Types** - Each with distinct personalities and care requirements
- 📊 **Vital Statistics System** - Manage Health, Sleep, Fullness, and Happiness
- 🎯 **Dynamic State Management** - Pets respond realistically with states like Sleeping, Hungry, Angry, and Normal
- 💾 **Save/Load System** - Multiple save slots for managing different pets
- 🎁 **Inventory Management** - Collect and use food and gift items
- 🏆 **Scoring System** - Track your performance as a pet caretaker

### Advanced Features
- 🎨 **Animated Sprites** - Pet expressions change based on mood and state
- ⌨️ **Keyboard Shortcuts** - Efficient gameplay with hotkeys (F to feed, G for gift, P for play)
- 👨‍👩‍👧 **Parental Controls** - Password-protected play time limits and statistics
- 📈 **Play Time Tracking** - Monitor total and average session durations
- 🔄 **Auto-Save** - Never lose your progress

## 🛠️ Technologies Used

- **Language:** Java 23
- **GUI Framework:** Java Swing
- **Testing:** JUnit 5 (95%+ code coverage)
- **Build Tool:** Maven/Gradle
- **Version Control:** Git/GitLab
- **Data Storage:** JSON/XML for save files
- **Design Patterns:** State Pattern, Observer Pattern, Factory Pattern, Singleton Pattern

## 🏗️ Architecture

The game follows object-oriented design principles with clear separation of concerns:
```
src/
├── model/          # Core game logic and data models
│   ├── Pet.java
│   ├── PetState.java
│   ├── Inventory.java
│   └── Statistics.java
├── view/           # GUI components and screens
│   ├── GameScreen.java
│   ├── MenuScreen.java
│   └── ParentalControlScreen.java
├── controller/     # Game logic and event handlers
│   ├── GameController.java
│   └── SaveLoadManager.java
└── utils/          # Helper classes and utilities
    ├── FileManager.java
    └── ConfigManager.java
```

### Key Design Patterns
- **State Pattern:** Manages pet states (Normal, Sleeping, Hungry, Angry, Dead)
- **Observer Pattern:** Updates UI when pet statistics change
- **Factory Pattern:** Creates different pet types with unique attributes
- **Singleton Pattern:** Manages game state and save/load operations

## 🚀 Getting Started

### Prerequisites
- Java 23 or newer
- Maven/Gradle (optional, for building)
- Windows 11 / macOS / Linux

### Installation

1. Clone the repository
```bash
git clone [your-repo-url]
cd virtual-pet-game
```

2. Compile the project
```bash
javac -d bin src/**/*.java
# OR if using Maven
mvn clean compile
```

3. Run the game
```bash
java -cp bin Main
# OR if using Maven
mvn exec:java
```

## 🎮 How to Play

### Getting Started
1. Launch the game and select **New Game** from the main menu
2. Choose one of three pet types
3. Name your pet and begin caring for them!

### Controls
| Action | Mouse | Keyboard |
|--------|-------|----------|
| Feed Pet | Click Feed Button | `F` |
| Give Gift | Click Gift Button | `G` |
| Play | Click Play Button | `P` |
| Sleep | Click Sleep Button | `B` |
| Exercise | Click Exercise Button | `E` |
| Vet Visit | Click Vet Button | `V` |
| Pause Game | Click Pause Button | `ESC` |
| Main Menu | Click Menu Button | `M` |

### Keeping Your Pet Happy
- 🍖 **Feed regularly** - Don't let fullness drop below 25%
- 😊 **Give gifts and play** - Maintain high happiness levels
- 😴 **Allow rest** - Let your pet sleep when tired
- 🏥 **Visit the vet** - When health is low (cooldown applies)
- 🏃 **Exercise** - Improves health but increases hunger

### Warning Signs
- 🔴 **Red indicators** - A vital statistic is below 25%
- 😠 **Angry state** - Pet will only accept gifts and playtime
- 😴 **Sleeping state** - Pet cannot be interacted with until fully rested
- 🍔 **Hungry state** - Happiness decreases faster, health deteriorates

## 📊 Game Mechanics

### Vital Statistics
All statistics range from 0 to 100 and decline at different rates:
- **Health:** Decreases when other stats reach 0. Game over at 0.
- **Sleep:** Decreases over time. Forces sleep state at 0.
- **Fullness:** Decreases steadily. Triggers hungry state at 0.
- **Happiness:** Decreases over time, faster when hungry. Triggers angry state at 0.

### Pet States
1. **Normal:** All commands available
2. **Sleeping:** No commands available until sleep reaches maximum
3. **Hungry:** All commands available, but happiness decreases faster
4. **Angry:** Only Give Gift and Play commands available
5. **Dead:** Game over - load save or start new game

### Scoring System
- ✅ **Gain points:** Feeding, giving gifts, playing, exercising
- ❌ **Lose points:** Vet visits, letting stats reach 0
- 🏆 **High scores** unlock rewards (if implemented)

## 🧪 Testing

The project includes comprehensive JUnit 5 tests covering:
- Pet state transitions
- Vital statistics calculations
- Save/load functionality
- Inventory management
- Command execution logic

Run tests:
```bash
mvn test
# OR
./gradlew test
```

**Test Coverage:** 95%+ (excluding GUI components)

## 📁 Save System

Save files are stored locally in `/saves/` directory as JSON/XML files containing:
- Pet type and name
- Current vital statistics
- Pet state
- Player inventory
- Current score
- Timestamp

Multiple save slots supported (minimum 3).

## 👨‍👩‍👧 Parental Controls

Access via main menu with password: `[your-password]`

Features:
- Set allowed play times (e.g., 3PM - 8PM on weekdays)
- View total play time and session averages
- Revive deceased pets
- Reset statistics

## 🎨 Assets & Credits

### Sprites
- Pet sprites sourced from [Spriters Resource - Tamagotchi Smart](https://www.spriters-resource.com/lcd_handhelds/tamagotchismart/)

### Libraries
- JSON parsing
All assets used under fair use for educational purposes.

## 🤝 Contributing

This is an academic project completed as part of CS2212 at Western University. The repository is maintained for portfolio purposes.

## 📄 License

This project was created for educational purposes as part of CS2212 at Western University.  

## 📞 Contact

For questions or feedback, reach out to:
- **Email:** bjasnav@gmail.com

## 🙏 Acknowledgments

- Western University CS2212 Course TA and Professor

---

**Made with ❤️ at Western University**
