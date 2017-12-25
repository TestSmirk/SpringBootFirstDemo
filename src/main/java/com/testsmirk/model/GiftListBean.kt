package com.testsmirk.model

data class GiftListBean(var action: String,
                        var application: String,
                        var code: Int,
                        var description: Any,
                        var organization: String,
                        var result: Boolean,
                        var status: Boolean,
                        var timestamp: Int,
                        var uri: String,
                        var entities: List<Entities>) {
    data class Entities(var animation: String,
                        var coin: String,
                        var effect: String,
                        var gid: String,
                        var icon: String,
                        var name_en: String,
                        var name_sc: String,
                        var name_tc: String,
                        var isSelected: Boolean,
                        var price: Double) {
    }
}
