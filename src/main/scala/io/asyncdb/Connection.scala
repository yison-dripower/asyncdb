package io.asyncdb

import cats.data.NonEmptyList
import cats.free.Free.liftF

trait Connection {
  def sendQuery(sql: String): Conn[Either[Throwable, Result]] =
    liftF[ConnA, Either[Throwable, Result]](SendQuery(sql))

  def sendPreparedStatement(
    sql: String,
    param: NonEmptyList[Data]
  ): Conn[Either[Throwable, Result]] =
    liftF[ConnA, Either[Throwable, Result]](SendPreparedStatement(sql, param))
}
