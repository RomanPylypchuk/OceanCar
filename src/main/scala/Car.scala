import Cars.factorCars
object Car extends App{

  val parseFactors: String => Option[List[Factor]] = factorsStr =>
  {
    val factorsStrs: List[String] = factorsStr.sliding(4,4).toList
    val factorChars: Set[Char] = factorsStrs.map(_.head).toSet

    if (factorChars.size == 5){
    val maybeFactors: List[Option[Factor]] = factorsStrs.map(factorStr => Factor(factorStr))
    //Need sequence, but don't use any libraries
    maybeFactors.flatten match{
      case allFactors if allFactors.length == 5 => Some(allFactors)
      case _ => None
    }
   } else None
  }

  def findSuitableCars(factors: List[Factor], minOccurences: Int = 2): Map[String, Double] = {

    val factorsCars: List[Set[String]] = factors.map(factor => factorCars(factor))
    val allFactorsCars: Set[String] = factorsCars.reduceLeft(_ union _)

    minOccurences match{
      case 5 => factorsCars.reduceLeft(_ intersect _).map(car => car -> 1.0).toMap

      case i if (i > 1) && (i < 5) =>
        val carOccurences = allFactorsCars.map{car =>
          val carInFactorSets: List[Boolean] = factorsCars.map(fCars => fCars(car))
          car -> carInFactorSets.count(identity)
        }.toMap

        val maxOccurences = carOccurences.values.max
        carOccurences.collect{case (car, occ) if occ >= minOccurences =>
          car -> occ / maxOccurences.toDouble
        }

      case _ => Map.empty
    }
  }

  val factorsStr: String =
    io.StdIn.readLine("Please enter OCEAN values (from 0 to 1) in any order with one significant digit, e.g. O0.3C1.0E0.9A0.1N0.2\n")
  val maybeFactors: Option[List[Factor]] = parseFactors(factorsStr)
  if (maybeFactors.isDefined) {
    println("Interpreting your input as:")
    maybeFactors.get.foreach(println)
    println
  }

  val suitableCars = maybeFactors.map(factors => findSuitableCars(factors))
  suitableCars match{
    case None => println("Sorry, wrong input format :(")
    case Some(oneCarMap) if oneCarMap.isEmpty => println("Sorry, no suitable cars for you, mate!")
    case Some(carMap) =>
      println("Here are your best car suggestions (score from 0 to 1):")
      carMap.toList.sortBy{_._2}.reverse.foreach{ case (car, score) => println(car + " : " + score)}
  }

}
