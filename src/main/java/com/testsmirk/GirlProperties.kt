package com.testsmirk

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by testsmirk on 17-1-27.
 */
@Component
@ConfigurationProperties(prefix = "girl")
class GirlProperties {
    var cupSize: String? = null
    var agel: Int? = null

}
