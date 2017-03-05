#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "Moonlight"
SECTION = "multimedia"
DEPENDS = ""
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = " git://github.com/tezcatli/moonlight-embedded;name=moonlight-embedded \
            git://github.com/tezcatli/moonlight-common-c;name=moonlight-common-c;destsuffix=git/third_party/moonlight-common-c \
            file://cmake.patch \
            file://imx.patch "

SRCREV_moonlight-embedded="51404afbae6aa695ea82c5ba2c76e44e250d6e89"
SRCREV_moonlight-common-c="5731a555ba8f3ca00838a264046486ce955b3ac1"

#GITDIR_moonlight-common-c=${GITDIR_moonlight-embedded}/moonlight-embedded/third_party

# Make sure our source directory (for the build) matches the directory structure in the tarball
S = "${WORKDIR}/git"

inherit pkgconfig cmake

DEPENDS = "alsa-lib libopus imx-vpu libevdev udev avahi enet curl v4l-utils pulseaudio"

RDEDENDS = "avahi v4l-utils"

PACKAGES="${PN} ${PN}-doc ${PN}-dbg"

FILES_${PN} += "${datadir}/moonlight/mappings/* /usr/lib/"


# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""
