# 🍔 Online Food Delivery System

A **console-based food delivery application** built with **Core Java**, simulating a real-world online food ordering experience. Users can browse restaurants, explore menus, place orders with quantity selection, apply discount coupons, and view a detailed order receipt — all through an interactive, menu-driven terminal interface.

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [How It Works](#-how-it-works)
- [Available Restaurants](#-available-restaurants)
- [Coupon Codes](#-coupon-codes)
- [Screenshots](#-screenshots)
- [OOP Concepts Used](#-oop-concepts-used)
- [Future Enhancements](#-future-enhancements)
- [License](#-license)

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| 🏪 **Browse Restaurants** | View all available restaurants with location and distance info |
| 📖 **View Menus** | Explore the full menu of any restaurant with item prices |
| 🛒 **Place Orders** | Select items, specify quantities, and build your cart |
| 🎟️ **Apply Coupons** | Use discount codes with percentage-based savings |
| 🧾 **Order Receipt** | Get a detailed receipt with subtotal, delivery fee, and discount breakdown |
| 📜 **Order History** | Track all your past orders with timestamps and totals |
| 🚚 **Delivery Fee Calculation** | Dynamic delivery charges based on restaurant distance |
| ⏱️ **Estimated Delivery Time** | Auto-calculated ETA based on distance |
| 🔒 **Robust Input Handling** | Crash-resistant input validation throughout the application |

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 8+)
- **Paradigm:** Object-Oriented Programming
- **Interface:** Console / Terminal (CLI)
- **IDE:** IntelliJ IDEA (recommended)

---

## 📁 Project Structure

```
OnlineFoodDeliverySystem/
├── src/
│   ├── OnlineFoodDeliverySystem.java   # Main class — entry point, menus, and UI
│   ├── Restaurant.java                 # Restaurant model with menu management
│   ├── FoodItem.java                   # Individual food item representation
│   ├── Order.java                      # Order processing, pricing, and receipt
│   ├── OrderHistory.java              # Tracks and displays past orders
│   └── Coupon.java                     # Discount coupon logic and validation
├── .gitignore
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- **Java JDK 8** or higher installed
- Any terminal / command prompt or a Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Clone the Repository

```bash
git clone https://github.com/<your-username>/OnlineFoodDeliverySystem.git
cd OnlineFoodDeliverySystem
```

### Compile & Run

```bash
# Navigate to the source directory
cd src

# Compile all Java files
javac *.java

# Run the application
java OnlineFoodDeliverySystem
```

> **💡 Tip:** If you're using IntelliJ IDEA, simply open the project folder and run `OnlineFoodDeliverySystem.java`.

---

## 🔄 How It Works

```
┌──────────────────────────────────────┐
│         MAIN MENU                    │
├──────────────────────────────────────┤
│  1. Browse Restaurants               │
│  2. Place an Order                   │
│  3. View Order History               │
│  4. View Available Coupons           │
│  5. Exit                             │
└──────────────────────────────────────┘
```

### Ordering Flow

1. **Select a restaurant** from the available list
2. **Browse the menu** and add items with desired quantities
3. **Apply a coupon** (optional) to get a percentage discount
4. **View your receipt** with a full breakdown of costs
5. **Order is saved** to your session history automatically

### Delivery Fee Formula

```
Delivery Fee = ₹20 (base) + (distance in km × ₹10/km)
```

### Estimated Delivery Time

```
ETA = (distance × 5) + 15 minutes
```

---

## 🏪 Available Restaurants

| # | Restaurant | Location | Distance | Speciality |
|---|-----------|----------|----------|------------|
| 1 | Burger King | Downtown | 2.5 km | Burgers, Fries & Drinks |
| 2 | Pizza Haven | Main Street | 1.8 km | Pizzas, Pasta & Garlic Bread |
| 3 | Sushi Express | Eastside | 4.2 km | Sushi Rolls, Tempura & Soup |
| 4 | Taco Fiesta | Westside | 0.5 km | Tacos, Nachos & Quesadillas |
| 5 | Curry House | Northside | 3.0 km | Indian Curries, Biryani & Naan |

---

## 🎟️ Coupon Codes

| Code | Discount | Min. Order |
|------|----------|------------|
| `SAVE10` | 10% off | ₹300 |
| `SAVE20` | 20% off | ₹500 |
| `WELCOME15` | 15% off | ₹200 |
| `FLAT50` | 50% off | ₹1,000 |
| `FIRSTORDER` | 25% off | ₹150 |

> Coupons are single-use per session and require the minimum order amount to be met.

---

## 📸 Screenshots

<details>
<summary>🏠 Welcome Screen & Main Menu</summary>

```
  ==========================================
     ONLINE FOOD DELIVERY SYSTEM
     Fast. Fresh. Delivered to You!
  ==========================================

  Welcome! Browse restaurants, place orders,
  and enjoy your meal at home.

  ========== MAIN MENU ==========
   1. Browse Restaurants
   2. Place an Order
   3. View Order History
   4. View Available Coupons
   5. Exit
```

</details>

<details>
<summary>🧾 Sample Order Receipt</summary>

```
  ============ ORDER RECEIPT ============
  Restaurant: Pizza Haven
  Distance:   1.8 km
  --------------------------------------
  Items Ordered:
    Margherita Pizza     x2    Rs. 500.00
    Garlic Bread         x1    Rs.  90.00
  --------------------------------------
  Subtotal:                  Rs.   590.00
  Discount (SAVE10):        -Rs.    59.00
  Delivery Fee (1.8 km):     Rs.    38.00
  ======================================
  TOTAL:                     Rs.   569.00
  ======================================

  Estimated delivery: ~24 minutes
  Order placed successfully!
```

</details>

---

## 🧩 OOP Concepts Used

| Concept | Where It's Applied |
|---------|-------------------|
| **Encapsulation** | All classes use `private` fields with public getters/setters |
| **Abstraction** | Internal pricing and delivery logic hidden behind clean method interfaces |
| **Arrays & Iteration** | Menu items, coupons, and order history managed via arrays |
| **Modular Design** | Separate classes for `Restaurant`, `FoodItem`, `Order`, `Coupon`, and `OrderHistory` |
| **Method Overriding** | `toString()` overridden in `FoodItem` for formatted output |
| **Static Members** | Delivery fee constants and shared scanner instance |

---

## 🚧 Future Enhancements

- [ ] User authentication (login / signup)
- [ ] Persistent storage with file I/O or database (MySQL / SQLite)
- [ ] GUI version using JavaFX or Swing
- [ ] Real-time order tracking simulation
- [ ] Payment gateway integration
- [ ] Restaurant rating and review system
- [ ] Search and filter menu items
- [ ] Admin panel for restaurant management

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

<div align="center">

**⭐ If you found this project helpful, give it a star!**

Made with ☕ and Java

</div>
