package scalaz
package typeclass

trait Functor[F[_]] {
  def map[A, B](ma: F[A])(f: A => B): F[B]
}
