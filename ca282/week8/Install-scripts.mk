installdir = $(HOME)/local/bin
source = $(wildcard [a-z]*)

install: $(installdir) $(addprefix $(installdir)/, $(source))
	@true

$(installdir)/%: %
	@install -v -m 0555 $< $@

$(installdir):
	mkdir -vp $@

.PHONY: install
