package io

import cats.free.Free

package object asyncdb {
  private[asyncdb] type Data    = Any
  private[asyncdb] type Result  = Any
  private[asyncdb] type Conn[A] = Free[ConnA, A]
}
