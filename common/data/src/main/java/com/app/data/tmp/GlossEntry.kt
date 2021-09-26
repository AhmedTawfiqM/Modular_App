package com.app.data.tmp

data class GlossEntry(val glossTerm: String = "",
                      val glossSee: String = "",
                      val sortAs: String = "",
                      val glossDef: GlossDef,
                      val id: String = "",
                      val acronym: String = "",
                      val abbrev: String = "")