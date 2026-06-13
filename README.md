# AI Chatbot — Spring Boot + Spring AI + Ollama

A fully local conversational AI chatbot built with Spring Boot and Spring AI, 
running llama3 via Ollama — no paid API dependencies.

## Tech Stack
- Java 8+ / Spring Boot
- Spring AI
- Ollama (llama3)
- PostgreSQL
- Docker & Docker Compose

## Features
- Context-aware multi-turn conversations
- Full chat history stored in PostgreSQL
- Runs entirely locally — no OpenAI or paid APIs needed
- One-command deployment via Docker Compose

## How to Run
1. Install Docker and Ollama locally
2. Clone this repository
3. Run: docker-compose up
4. Access the chatbot at http://localhost:8080
