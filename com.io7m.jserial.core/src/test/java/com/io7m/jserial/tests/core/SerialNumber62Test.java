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

package com.io7m.jserial.tests.core;

import com.io7m.jserial.core.SerialNumber62;
import com.io7m.jserial.core.SerialNumberLongType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SerialNumber62Test extends SerialNumberLongContract
{
  private static final Logger LOG;

  static {
    LOG = LoggerFactory.getLogger(SerialNumber62Test.class);
  }

  @Override
  protected SerialNumberLongType get()
  {
    return SerialNumber62.get();
  }

  @Override
  protected Logger log()
  {
    return LOG;
  }

  @Override
  protected long integerBits()
  {
    return 62L;
  }

  @Override
  protected long nearLargestValue()
  {
    return 0x3fff_ffff_ffff_ffffL - 3L;
  }
}
