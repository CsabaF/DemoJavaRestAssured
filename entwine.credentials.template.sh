#
# Local development environment configuration.
#
export ENTWINE_CONFIG_FILE_VERSION=0.1



# END2END TESTS
# Supported target environments are: sprint, staging or nightly

# target environment for `npm run e2e:browserstack`
export ENTWINE_E2E_BROWSERSTACK_TARGET=sprint

# target environment for `npm run e2e:local`
export ENTWINE_E2E_LOCAL_TARGET=sprint



# CREDENTIALS

# for browserstack automate
export ENTWINE_BROWSERSTACK_USERNAME=user
export ENTWINE_BROWSERSTACK_ACCESS_KEY=key

# for staging
export ENTWINE_STAGING_USER=admin
export ENTWINE_STAGING_PASSWORD=pwd

# for nightly
export ENTWINE_NIGHTLY_USER=admin
export ENTWINE_NIGHTLY_PASSWORD=pwd

# for sprint
export ENTWINE_SPRINT_USER=admin
export ENTWINE_SPRINT_PASSWORD=pwd

# for feature instances
export ENTWINE_FI_USER=admin
export ENTWINE_FI_PASSWORD=pwd

# for digest request user
export ENTWINE_DIGEST_USER=
export ENTWINE_DIGEST_PASSWORD=

