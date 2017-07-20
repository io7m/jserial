/*
 * Copyright © 2016 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jserial.core;

/**
 * An implementation of 8-bit serial number arithmetic.
 */

public final class SerialNumber8 implements SerialNumberIntType
{
  private static final SerialNumber8 INSTANCE;

  static {
    INSTANCE = new SerialNumber8();
  }

  private SerialNumber8()
  {

  }

  /**
   * @return A serial number calculator
   */

  public static SerialNumberIntType get()
  {
    return SerialNumber8.INSTANCE;
  }

  @Override
  public int add(
    final int s0,
    final int s1)
  {
    final int d = s0 + s1;

    /**
     * Pretend that d is an unsigned 8 bit value by masking off the high 24
     * bits.
     */

    return d & 0x000000ff;
  }

  @Override
  public int bits()
  {
    return 8;
  }

  @Override
  public int distance(
    final int s0,
    final int s1)
  {
    final int s0_8 = s0 & 0xff;
    final int s1_8 = s1 & 0xff;
    final int d = s1_8 - s0_8;
    final int r;
    if (d > 0x7f) {
      r = 0x7f - d;
    } else {
      r = d;
    }
    return r;
  }

  @Override
  public int compare(
    final int s0,
    final int s1)
  {
    return -this.distance(s0, s1);
  }

  @Override
  public boolean inRange(
    final int s0)
  {
    return (s0 >= 0) && (s0 <= 0xff);
  }
}