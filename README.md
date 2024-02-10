# Currency Exchange Service

## Overview

Currency Exchange Service is a backend service designed to provide current exchange rates for currencies like USD, EUR, RUB against KZT, and to convert amounts between different currencies (e.g., from USD to KZT). Built with Spring Boot, the service offers a REST API for interaction.

## Features

- **Get Current Exchange Rates**: API endpoint to retrieve the latest exchange rates for currencies such as USD, EUR, RUB, etc., relative to KZT.
- **Currency Conversion**: API supports converting a specified amount from one currency to another using the current exchange rate.

## Technologies

- Spring Boot
- Maven
- RESTful API
- JSON Processing with Jackson

## API Usage

### Get Current Exchange Rates

- **Request**: `GET /api/rates`
- **Response**: JSON with current exchange rates to KZT.

```json
{
  "USD": 450.50,
  "EUR": 500.25,
  "RUB": 5.75
}
```

### Convert Currency

- **Request**: `POST /api/convert`
- **Request Param**:

```json
{
  "from": "USD",
  "to": "KZT",
  "amount": 10
}
```

- **Response**: JSON with the conversion result.

```json
{
  "result": "4500 KZT"
}
```