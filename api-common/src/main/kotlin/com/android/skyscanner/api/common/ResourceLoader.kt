package com.mifli.api.common.utils

import java.io.BufferedReader

fun <T : Any> Class<T>.loadJsonAsText(path: String): String =
    getResourceAsStream(path)?.bufferedReader()?.use(BufferedReader::readText).orEmpty()