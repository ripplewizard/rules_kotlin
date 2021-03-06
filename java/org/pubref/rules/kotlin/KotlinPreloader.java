/*
 * Copyright 2017 PubRef.org. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.pubref.rules.kotlin;

import com.google.common.collect.Iterables;
import io.bazel.rules.closure.program.CommandLineProgram;
import org.jetbrains.kotlin.preloading.Preloader;

/**
 * CommandLineProgram Wrapper for the Kotlin Preloader.
 */
public final class KotlinPreloader implements CommandLineProgram {

  @Override
  public Integer apply(Iterable<String> args) {
    try {
      Preloader.main(Iterables.toArray(args, String.class));
      return 0;
    } catch (Exception ex) {
      ex.printStackTrace();
      return 1;
    }
  }

}
