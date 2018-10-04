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

function editTopic() {
    $('#btnSaveTopic').show();
    $('.toggle_inputs_').prop('disabled', false);
    $('#btnEditTopic').hide();
}

function bindDeleteButtons() {
    $('body').on('click', '.topic_delete_', (event) => {
        event.preventDefault();

        const $button = $(event.currentTarget);
        const topicName = $button.data('topicname');

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

  $('#btnEditTopic').click(editTopic);
});
