package scalaz

import org.scalacheck.Prop._

import scalaz.scalacheck.ScalazProperties._
import scalaz.scalacheck.ScalazArbitrary._
import std.AllInstances._
import org.scalacheck.Prop.forAll

object OneOrTest extends SpecLite {
  import OneOr._
  checkAll("OneOr", equal.laws[OneOr[List, Int]])
  checkAll("OneOr", order.laws[OneOr[List, Int]])
  checkAll("OneOr List", traverse.laws[OneOrList])
  checkAll("OneOr List", applicative.laws[OneOrList])
  checkAll("OneOr Nel", traverse1.laws[OneOrNel])
  checkAll("OneOr Nel", comonad.laws[OneOrNel])

//  "inequality exists" ! forAll {(a: OneOrList[Int]) =>
//    exists {(b: OneOrList[Int]) =>
//      propBoolean(!Equal[OneOrList[Int]].equal(a, b))
//    }
//  }

  object instances {
    def functor[F[_]: Functor] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def apply[F[_]: Apply] = Apply[({type λ[α] = OneOr[F, α]})#λ]
    def applicative[F[_]: Apply] = Applicative[({type λ[α] = OneOr[F, α]})#λ]
    def cobind[F[_]: Cobind] = Cobind[({type λ[α] = OneOr[F, α]})#λ]
    def comonad[F[_]: Comonad] = Comonad[({type λ[α] = OneOr[F, α]})#λ]
    def foldable[F[_]: Foldable] = Foldable[({type λ[α] = OneOr[F, α]})#λ]
    def foldable1[F[_]: Foldable1] = Foldable1[({type λ[α] = OneOr[F, α]})#λ]
    def traverse[F[_]: Traverse] = Traverse[({type λ[α] = OneOr[F, α]})#λ]
    def traverse1[F[_]: Traverse1] = Traverse1[({type λ[α] = OneOr[F, α]})#λ]

    // checking absence of ambiguity
    def functor[F[_]: Apply] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Cobind] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Comonad] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Traverse] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Traverse1] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Apply: Cobind] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Apply: Comonad] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Apply: Traverse] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Apply: Traverse1] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Cobind: Traverse] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Cobind: Traverse1] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Comonad: Traverse] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def functor[F[_]: Comonad: Traverse1] = Functor[({type λ[α] = OneOr[F, α]})#λ]
    def cobind[F[_]: Comonad] = Cobind[({type λ[α] = OneOr[F, α]})#λ]
    def foldable[F[_]: Foldable1] = Foldable[({type λ[α] = OneOr[F, α]})#λ]
    def traverse[F[_]: Traverse1] = Traverse[({type λ[α] = OneOr[F, α]})#λ]
  }

}
