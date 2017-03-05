COMPATIBLE_MACHINE = "moonlight-imx6"

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI_append=" file://012-hb1-fb-device.patch "
