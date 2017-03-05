#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "enet network library"
SECTION = "console/network"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=aaf84060799e2a3961d38aa9316c31ab"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}_${PV}:"

SRC_URI = "http://enet.bespin.org/download/enet-${PV}.tar.gz"

SRC_URI[md5sum] = "b83b9a7791417b6b6f5c68231f6e218b"
SRC_URI[sha256sum] = "e36072021faa28731b08c15b1c3b5b91b911baf5f6abcc7fe4a6d425abada35c"

# Make sure our source directory (for the build) matches the directory structure in the tarball
S = "${WORKDIR}/enet-${PV}"

inherit autotools

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""
