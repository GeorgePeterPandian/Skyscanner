package com.android.skyscanner.uk.flights.model

data class FlightsUIM(
  val id: String,
  val leg1AirlineId: String,
  val leg2AirlineId: String,
  val leg1TimeDetails: String,
  val leg2TimeDetails: String,
  val leg1AirportAndProviderDetails: String,
  val leg2AirportAndProviderDetails: String,
  val leg1Stops: String,
  val leg2Stops: String,
  val leg1Duration: String,
  val leg2Duration: String,
  val price: String,
  val provider: String
)