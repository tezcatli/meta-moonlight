#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "brcm_patchram_plus"
SECTION = "bsp"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://brcm_patchram_plus.c;md5=627e9612337e5ef6027a87a79c491446"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "http://sources.libreelec.tv/devel/brcmfmac_sdio-firmware-imx-0.1.tar.xz \
           file://patchram;subdir=brcmfmac_sdio-firmware-imx-0.1 \
	   file://80-brcmfmac_sdio.rules;subdir=brcmfmac_sdio-firmware-imx-0.1"
SRC_URI[sha256sum] = "4c8ed8ae39ecd05d7e3aeebc98cf230912cdcc887fa78d5112f981b6f9358b6e"

# Make sure our source directory (for the build) matches the directory structure in the tarball
S = "${WORKDIR}/brcmfmac_sdio-firmware-imx-0.1"

inherit pkgconfig 

DEPENDS = "libevdev udev"

# PACKAGES="${PN}"

FILES_${PN} += "/lib/firmware/brcm/"

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""

do_compile() {
        oe_runmake all 'CC=${CC}'
}

do_install() {
        oe_runmake install 'DESTDIR=${D}'
	install -m 0755 -d ${D}/etc/init.d/
	install -m 0755 ${S}/patchram ${D}/etc/init.d/patchram
	install -m 0755 -d ${D}/etc/udev/rules.d/
	install -m 0755 ${S}/80-brcmfmac_sdio.rules ${D}/etc/udev/rules.d/80-brcmfmac_sdio.rules
}
