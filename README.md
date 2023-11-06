# Vape Shop
***
## Table of Contents:
1. Introduction
2. Project Overview
3. Project Structure
4. Design Patterns
   * Observer Pattern
   * Factory Pattern
   * Adapter Pattern
   * Decorator Pattern
   * Singleton Pattern
   * Strategy Pattern
5. Conclusion
***
## 1. Introduction:
#### Welcome to the documentation for the Vape Shop project. This document provides an overview of the Vape Shop system, explaining how it works and detailing the design patterns used in its implementation.
***
## 2. Project Overview:
#### The Vape Shop project is a console e-commerce system for selling vape products. It allows customers to browse and purchase different types of vape products, such as e-liquids (ejuice) and vape devices, in a user-friendly manner. The project incorporates several design patterns to enhance its functionality and maintainability. In addition, this project has opportunity for admins to add new products and notify customers and other admins about new products.
***
## 3. Project Structure:
#### The project is organized into different packages, each serving a specific purpose:
*  Adapter: Contains classes and interfaces that implement the Adapter Pattern to adapt different promo code payment methods.
*  Decorator: Includes classes that implement the Decorator Pattern to enhance vape liquids with additional features like nicotine levels.
*  Factory: Contains classes and interfaces that implement the Factory Pattern for creating different types of vape products.
*  Observer: Implements the Observer Pattern for notifying users or admins of changes in the shop.
*  Singleton: Contains a class that implements the Singleton Pattern for managing sales.
*  Strategy: Houses classes and interfaces that implement the Strategy Pattern to handle payment methods.
*  Main: Contains the main class responsible for user interaction and payment processing.
***
## 4. Design Patterns:
### Observer Pattern
* __Description:__ The Observer Pattern is used to notify users, customers, and admins of changes in the shop, such as the addition of new products.
* __Implementation:__ The VapeShop class maintains a list of observers (admins and customers) and notifies them of changes. Both the Admin and Customer classes implement the ShopObserver interface to receive updates.
### Factory Pattern
* __Description:__ The Factory Method Pattern is used to create instances of different vape products (Ejuice and VapeDevice) without exposing their creation logic.
* __Implementation:__ The VapeProductFactory interfaces and their respective implementations (EjuiceFactory and VapeDeviceFactory) encapsulate the creation process of vape products.
### Adapter Pattern
* __Description:__ The Adapter Pattern is employed to adapt various payment methods to a common interface, enabling the system to process payments without knowledge of the specific payment method.
* __Implementation:__ The PaymentAdapter class adapts different payment methods (Cash, Credit Card, Paypal) to the IPayment interface, allowing payment processing.
### Decorator Pattern
* __Description:__ The Decorator Pattern is used to add extra features, such as nicotine levels, to vape liquids without modifying their base classes.
* __Implementation:__ Various classes like LowNicotineVapeLiquid and HighNicotineVapeLiquid extend the NicotineDecorator, which in turn extends the ILiquid interface. These classes enhance vape liquids with nicotine information.
### Singleton Pattern
* __Description:__ The Singleton Pattern is applied to the Sales class to ensure that only one instance of the sales class is created, making it a reliable source for managing sales information.
* __Implementation:__ The Sales class has a private constructor and a static method to access the single instance of the class, guaranteeing that only one instance exists.
### Strategy Pattern
* __Description:__ The Strategy Pattern is used to encapsulate different payment methods (Cash, Credit Card, Paypal) and make them interchangeable. It allows the system to select the appropriate payment method at runtime.
* __Implementation:__ The IPayment interface defines the pay method, which is implemented by different payment methods such as Paypal, Cash, and CreditCard. The PaymentAdapter class adapts these methods to the common interface.
***
## 5. Conclusion
#### The Vape Shop project is designed as an efficient and extendable e-commerce platform for vape products. It employs several design patterns to enhance its functionality, maintainability, and flexibility. The Observer Pattern notifies users and admins of shop changes, the Factory Pattern handles product creation, the Adapter Pattern adapts payment methods, the Decorator Pattern enhances vape liquids, the Singleton Pattern manages sales, and the Strategy Pattern handles various payment methods. This modular and pattern-based architecture ensures that the project can easily adapt to future requirements and remain maintainable and scalable.