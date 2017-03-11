COMPATIBLE_MACHINE = "moonlight-imx6"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI_append=" file://012-hb1-fb-device.patch \
                 file://0001-imx6-Fix-SD-offset-to-align-with-mainline-value.patch \
                 file://gcc6-fix.patch "
