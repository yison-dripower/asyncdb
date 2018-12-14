package io.asyncdb
package nio
package mysql

import cats.syntax.all._
import cats.effect.Async
import cats.arrow.FunctionK
import cats.{Id, ~>}

class MySQLConnection[F[_]](socket: MySQLSocket[F])(implicit F: Async[F])
    extends Connection {

  def impureCompiler: ConnA ~> Id =
    new (ConnA ~> Id) {

      def apply[A](fa: ConnA[A]): Id[A] =
        fa match {
          case SendQuery(sql) =>
            ???
          case SendPreparedStatement(sql, param) =>
            ???
        }
    }

  def connect    = socket.connect.as(this)
  def disconnect = socket.disconnect
}
