package codes.romain.kotlinx.bootstrap.demo.components

import codes.romain.bootstrap.kotlinx.html.AlertType
import codes.romain.bootstrap.kotlinx.html.alert
import codes.romain.bootstrap.kotlinx.html.alertHeading
import codes.romain.bootstrap.kotlinx.html.alertLink
import codes.romain.kotlinx.bootstrap.demo.componentSection
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.h4
import kotlinx.html.p


fun FlowContent.alerts() {
    componentSection(
        "Alerts",
        "https://getbootstrap.com/docs/5.3/components/alerts",
        """
                            alert(AlertType.Success) {
                                h4 {
                                    alertHeading()
                                    +"Welcome!"
                                }
                                p {
                                    +"Account has be successfully created, use the email address and the password to sign in."
                                }
            
                                p("m-0") {
                                    a("/") {
                                        alertLink()
                                        +"Go To Sign In Page"
                                    }
                                }
                            }
                        """
    ) {
        alert(AlertType.Success) {
            h4 {
                alertHeading()
                +"Welcome!"
            }
            p {
                +"Account has be successfully created, use the email address and the password to sign in."
            }

            p("m-0") {
                a("/") {
                    alertLink()
                    +"Go To Sign In Page"
                }
            }
        }
    }
}