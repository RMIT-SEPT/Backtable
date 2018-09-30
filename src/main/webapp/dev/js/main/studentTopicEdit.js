import {
    showModalConfirmation,
} from '../common/bootboxWrapper';

import {
    ParamsNames,
    BootstrapContextualColors,
} from '../common/const';

import {
    scrollToElement,
} from '../common/scrollTo';

function bindDeleteButtons() {
    $('body').on('click', '.topic_delete_', (event) => {
        event.preventDefault();

        const $button = $(event.currentTarget);
        const topicName = $button.data('topicname');

        console.log("Deleting " + topicName);

        const messageText = `Are you sure you want to delete the topic ${topicName}?`;

        const okCallback = function () {
            window.location = $button.attr('href');
        };

        showModalConfirmation('Confirm deleting topic', messageText, okCallback, null,
                null, null, BootstrapContextualColors.DANGER);
    });
}

$(document).ready(() => {
  bindDeleteButtons();
});
