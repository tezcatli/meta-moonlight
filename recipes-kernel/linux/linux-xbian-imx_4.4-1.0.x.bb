
# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP i.MX Linux kernel with backported features and fixes"
DESCRIPTION = "Linux kernel based on NXP 4.1.2.0 GA release, used by FSL Community BSP in order to \
provide support for i.MX based platforms and include official Linux kernel stable updates, backported \
features and fixes coming from the vendors, kernel community or FSL Community itself."


#include recipes-kernel/linux/linux-fslc.inc
require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}_${PV}:"

PV .= "+git${SRCPV}"

SRCBRANCH = "imx6-4.4.y"
SRCREV = "3bde86305d09f243fd7c59cd19c4cad50bcd92cb"

COMPATIBLE_MACHINE = "(mx6|mx7)"

SRC_URI = "git://github.com/xbianonpi/xbian-sources-kernel.git;branch=${SRCBRANCH} \
           file://defconfig"


SRC_URI += "file://pmu.patch \
            file://mxc_pix_format.patch \
            file://mxc_vout.patch \
            file://dts.patch"

#            file://mxc_pix_format.patch
#            file://mxc_vout.patch


include linux-install-headers.inc
