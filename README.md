# 📈 Liquidity Aggregator

## 📌 Overview
The **Liquidity Aggregator** is a high-performance, concurrent data structure that maintains buy and sell orders sorted by price and quantity. It supports real-time order insertion, updating, deletion, and retrieval, making it ideal for financial applications such as trading platforms and exchanges.

## ✨ Features
- 📊 **Bid/Ask Management**: Supports buy and sell orders sorted by price and quantity.
- 🔄 **Order Updates**: Modify existing orders based on unique order IDs.
- 🗑 **Order Deletion**: Remove orders safely without affecting system performance.
- 📜 **Order Book Snapshot**: Retrieve the current state of the order book at any time.
- 🧵 **Thread-Safe**: Uses `ConcurrentSortedSot` for multi-threaded environments.
