import scala.util.Try
import scala.util.matching.Regex

sealed trait Factor {
  def value: Factor.Value
}

object Factor extends Enumeration{
  val low, high = Value
  val oneFactorRegex: Regex = "([A-Z])(\\d.\\d)".r

  val parseFactor: String => String => Option[Factor] =
    factorName =>
      factorValue =>
      {
        val binaryFactorValue: Option[Factor.Value] = for{
            factorDouble <- Try(factorValue.toDouble).toOption
          } yield if (factorDouble < 0.5) Factor.low else Factor.high

        binaryFactorValue.flatMap{factorValue => factorName match{
          case "O" => Some(Openness(factorValue))
          case "C" => Some(Conscientiousness(factorValue))
          case "E" => Some(Extraversion(factorValue))
          case "A" => Some(Agreeableness(factorValue))
          case "N" => Some(Neuroticism(factorValue))
          case _  => None
        }
       }
      }

  def apply(factorStr: String): Option[Factor] = factorStr match {
      case oneFactorRegex(fNameStr, fValueStr) => parseFactor(fNameStr)(fValueStr)
      case _ => None
    }
}

case class Openness(value: Factor.Value) extends Factor
case class Conscientiousness(value: Factor.Value) extends Factor
case class Extraversion(value: Factor.Value) extends Factor
case class Agreeableness(value: Factor.Value) extends Factor
case class Neuroticism(value: Factor.Value) extends Factor
