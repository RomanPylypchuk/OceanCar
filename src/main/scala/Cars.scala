object Cars {

  val lowOpenness = Set("Buick", "Lincoln", "Oldsmobile", "Range Rover", "Rolls-Royce")
  val highOpenness = Set("Lotus", "Mini", "Scion", "Subaru")
  val lowConscientiousness = Set("Ferrari", "Jeep", "Mitsubishi", "Pontiac")
  val highConscientiousness = Set("Acura", "Honda", "Lexus", "Volvo", "Toyota")
  val lowExtraversion = Set("Acura", "Hyundai", "Lexus", "Saab", "Subaru", "Volvo")
  val highExtraversion = Set("Aston Martin", "BMW", "Ferrari", "Mini", "Porsche")
  val lowAgreeableness = Set("BMW", "Hummer", "Maserati", "Mercedes", "Nissan")
  val highAgreeableness = Set("Acura", "Daewoo", "Geo", "Kia", "Saturn")
  val lowNeuroticism = Set("Acura", "Porsche", "Scion")
  val highNeuroticism = Set("Volkswagen", "Volvo")

  val factorCars: Factor => Set[String] = {
    case Openness(Factor.low) => lowOpenness
    case Openness(Factor.high) => highOpenness

    case Conscientiousness(Factor.low) => lowConscientiousness
    case Conscientiousness(Factor.high) => highConscientiousness

    case Extraversion(Factor.low) => lowExtraversion
    case Extraversion(Factor.high) => highExtraversion

    case Agreeableness(Factor.low) => lowAgreeableness
    case Agreeableness(Factor.high) => highAgreeableness

    case Neuroticism(Factor.low) => lowNeuroticism
    case Neuroticism(Factor.high) => highNeuroticism
  }
}
