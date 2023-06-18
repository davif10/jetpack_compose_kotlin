package com.example.myanimes

class DataSource {

    fun listCharacters() : List<CharacterData> = listOf(
        CharacterData(R.drawable.son_goku_kakarotto, R.string.son_goku),
        CharacterData(R.drawable.light_yagami_kira, R.string.light_yagami),
        CharacterData(R.drawable.monkey_d_luffy, R.string.monkey_d_luffy),
        CharacterData(R.drawable.naruto_uzumaki, R.string.naruto_uzumaki),
        CharacterData(R.drawable.natsu_dragneel, R.string.natsu_dragneel),
        CharacterData(R.drawable.seiya_pegaso, R.string.seiya_pegaso),
        CharacterData(R.drawable.kurosaki_ichigo, R.string.kurosaki_ichigo),
        CharacterData(R.drawable.yami_yugi, R.string.yami_yugi),
    )

    fun listWorld() : List<WorldData> = listOf(
        WorldData(R.drawable.konoha, R.string.konoha),
        WorldData(R.drawable.soul_society_seireitei, R.string.soul_society_seireitei),
        WorldData(R.drawable.toon_world, R.string.toon_world),
        WorldData(R.drawable.mr_kaioh_planet, R.string.mr_kaioh_planet),
        WorldData(R.drawable.marineford, R.string.marineford),
        WorldData(R.drawable.guild_fairy_tail, R.string.guild_fairy_tail),
        WorldData(R.drawable.zodiac_houses, R.string.zodiac_houses),
        WorldData(R.drawable.dueling_arena, R.string.dueling_arena),
    )
}