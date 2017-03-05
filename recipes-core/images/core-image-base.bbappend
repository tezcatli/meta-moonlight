#IMAGE_INSTALL += " libopus ne10 libevdev pulseaudio libpulse libpulse-simple imx-vpu libsdl2 curl enet jpeg v4l-utils iperf3 iperf ethtool alsa-utils "

IMAGE_INSTALL += " moonlight-embedded "

TOOLCHAIN_TARGET_TASK += " alsa-lib-dev libopus-dev libevdev-dev pulseaudio imx-vpu-dev libsdl2-dev kernel-dev curl-dev enet-dev v4l-utils kernel-dev linux-xbian-imx-soc-headers "
