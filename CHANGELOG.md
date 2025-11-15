# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.0.0] - 2025-08-01

### Added
- Initial release of the AI Chat application
- Java Swing GUI chat interface (`trochuyen.java`) for interacting with AI models
- Support for multiple AI model endpoints:
  - Local LM Studio integration
  - OpenRouter API support
  - Ollama4j integration for local Llama models
- Streaming chat responses with real-time text updates
- Multiple AI model options including:
  - Google Gemma 2 9B
  - Llama 3 models
  - DeepSeek R1
  - Mistral 7B Instruct
- Maven project configuration with Ollama4j dependency
- Demo class (`Demotrochyen.java`) for AI interaction
- HTML demo pages (aaaa.html, abc.html, acb.html, indexcuaan.html)
- JavaScript form validation (aa.js)

### Features
- Toggle-able chat interface panel
- Multi-threaded chat handling for non-blocking UI
- UTF-8 character encoding support for Vietnamese language
- Response formatting with automatic line breaks
- Chat history display in scrollable text pane
- Three different sending options:
  - Streaming API chat
  - Local model chat
  - Standard API chat

### Technical Details
- Built with Java 17
- Maven build system
- HTTP/1.1 client for API communication
- Swing GUI components with NetBeans Form Editor
- Support for configurable API endpoints and models

[Unreleased]: https://github.com/ln678090/duangit/compare/v1.0.0...HEAD
[1.0.0]: https://github.com/ln678090/duangit/releases/tag/v1.0.0
